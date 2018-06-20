package hu.tarnai.minerva.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ResourceUtils;

import hu.tarnai.minerva.objects.NapimenuJasperObj;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperUtil {
	private JasperReport report;
	private byte[] pdfBlob;
	private String path = "";

	public JasperUtil(String reportName) {
		try {
			File sourceFile = ResourceUtils.getFile("classpath:static/jasper/compile/" + reportName);
			path = sourceFile.getAbsolutePath();
			path = path.substring(0,path.length()-reportName.length());
			report = (JasperReport) JRLoader.loadObject(sourceFile);
		} catch (JRException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void printNapimenu(String date, List<NapimenuJasperObj> obj, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String,Object>();
		OutputStream output;
		
		response.setContentType("application/pdf");
		response.addHeader("content-disposition", "inline;");

		map.put("date", date);
		map.put("SUBREPORT_DIR", "/static/jasper/compile/");
		map.put("sub_obj", new CustomDataSource(obj.toArray(new NapimenuJasperObj[obj.size()])));
		map.put("sub_obj_copy", new CustomDataSource(obj.toArray(new NapimenuJasperObj[obj.size()])));
		
		try {
			
			pdfBlob = JasperRunManager.runReportToPdf(report, map, new CustomDataSource(new Object[] { new Object() } ));
			output = response.getOutputStream();
			output.write(pdfBlob);
			output.flush();
			output.close();
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printBookingTable(HashMap<String,Object> map, HttpServletResponse response) {
		OutputStream output;
		
		response.setContentType("application/pdf");
		response.addHeader("content-disposition", "inline;");
		
		try {
			
			pdfBlob = JasperRunManager.runReportToPdf(report, map, new CustomDataSource(new Object[] { new Object() } ));
			output = response.getOutputStream();
			output.write(pdfBlob);
			output.flush();
			output.close();
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}

	public JasperReport getReport() {
		return report;
	}

	public void setReport(JasperReport report) {
		this.report = report;
	}

	public byte[] getPdfBlob() {
		return pdfBlob;
	}

	public void setPdfBlob(byte[] pdfBlob) {
		this.pdfBlob = pdfBlob;
	}
	
}
