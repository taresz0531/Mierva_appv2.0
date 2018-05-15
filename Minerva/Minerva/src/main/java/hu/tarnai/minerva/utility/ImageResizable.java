package hu.tarnai.minerva.utility;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class ImageResizable {

	public byte[] resizeImageAsJPG(byte[] pImageData, int pMaxWidth) throws IOException {
		ImageIcon imageIcon = new ImageIcon(pImageData);
		int width = imageIcon.getIconWidth();
		int height = imageIcon.getIconHeight();
		
		if (pMaxWidth > 0 && width > pMaxWidth) {
		    double ratio = (double) pMaxWidth / imageIcon.getIconWidth();
		    height = (int) (imageIcon.getIconHeight() * ratio);
		    width = pMaxWidth;
		}
		
		BufferedImage bufferedResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedResizedImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.drawImage(imageIcon.getImage(), 0, 0, width, height, null);
		g2d.dispose();
		
		ByteArrayOutputStream encoderOutputStream = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(encoderOutputStream);
		encoder.encode(bufferedResizedImage);
		byte[] resizedImageByteArray = encoderOutputStream.toByteArray();
		
		return resizedImageByteArray;
	}
}
