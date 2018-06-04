package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.bo.EtlapBo;
import hu.tarnai.minerva.bo.EtlapKategoriaBo;
import hu.tarnai.minerva.entity.Etlap;
import hu.tarnai.minerva.entity.Etlapkategoria;

public class EtlapObject extends Etlapkategoria{
	private static final long serialVersionUID = 1L;
	
	public List<Etlap> etelek = new ArrayList<Etlap>();

	public EtlapObject() {
		super();
	}
	
	public static List<EtlapObject> get(){
		EtlapKategoriaBo katBo = new EtlapKategoriaBo();
		EtlapBo etlapBo = new EtlapBo();
		
		List<Etlapkategoria> kat = katBo.getActive();
		List<Etlap> et = etlapBo.getActive();
		List<EtlapObject> etObj = new ArrayList<EtlapObject>();
		
		for(Etlapkategoria k : kat){
			EtlapObject o = new EtlapObject();
			o.setId(k.getId());
			o.setNev(k.getNev());
			o.setSorrend(k.getSorrend());
			
			for(Etlap e : et){
				if(e.getKategoria() == o.getId()){
					o.etelek.add(e);
				}
			}
			
			
			etObj.add(o);
		}
		
		for(int i=0; i<etObj.size(); i++) {
			if(etObj.get(i).getEtelek().size() == 0) {
				etObj.remove(i);
				i=0;
			}
		}
		
		return etObj;
	}

	public List<Etlap> getEtelek() {
		return etelek;
	}

	public void setEtelek(List<Etlap> etelek) {
		this.etelek = etelek;
	}
	
	
}
