package com.oosd.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.oosd.dao.GameDAO;
import com.oosd.hibernate.HibernateUtil;
import com.oosd.model.Game;

public class GameDAOImpl implements GameDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public GameDAOImpl( ) {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Transactional
	public void add(Game game) {
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(game);
		transaction.commit();
	}
	
	@Transactional
	public void edit(Game game) {
		sessionFactory.getCurrentSession().update(game);
	}
	
	@Transactional
	@Override
	public Game getGame(int gameId) {
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		Game game = (Game)sessionFactory.getCurrentSession().get(Game.class, gameId);	
		transaction.commit();
		return game;
	}
	
	@Transactional
	@Override
	public void delete(int gameId) {
		sessionFactory.getCurrentSession().delete(getGame(gameId));
	}
	
	public ArrayList<String> getAllGameNames()
	{
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		List<Game> games = sessionFactory.getCurrentSession().createQuery("from Game").list();
		
		ArrayList<String> allGameNames = new ArrayList<String>();
		
		for(Game game : games) {
			String gameName = null;
			gameName = game.getGameName();
			
			allGameNames.add(gameName);
	
		}
		transaction.commit();
		return allGameNames;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
