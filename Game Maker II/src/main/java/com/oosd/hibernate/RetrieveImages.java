package com.oosd.hibernate;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RetrieveImages {  


	public ArrayList<Image> getImages(String type) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		List<Resources> resources = null;

		if(type.equals("background"))
			resources = session.createQuery("from Resources where type = 'background'").list();

		else if(type.equals("sprite"))
			resources = session.createQuery("from Resources where type = 'sprite'").list();


		session.close();

		ArrayList<Image> images = new ArrayList<Image>();

		for (Resources resource : resources) {
			byte[] imageData = null;
			try {
				imageData = resource.getImage();
			} catch (Exception e) {

				e.printStackTrace();
			}

			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageData);

			//while (byteArrayInputStream.available() > 0) {
				try {
					BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
					ImageIcon icon = new ImageIcon(bufferedImage);
					Image image = icon.getImage();	
					images.add(image);
					byteArrayInputStream.close();
					//System.out.println("done");
				} catch (IOException e) {
					e.printStackTrace();
				}
			//}

		}
		return images;
	}

}    
