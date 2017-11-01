package com.oosd.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.oosd.dao.ScoreDAO;
import com.oosd.hibernate.HibernateUtil;
import com.oosd.model.Score;

public class ScoreDAOImpl implements ScoreDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public ScoreDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();

	}

	@Override
	public void add(Score score) {
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(score);
		transaction.commit();

	}

	@Override
	@Transactional
	public void edit(Score score) {
		sessionFactory.getCurrentSession().update(score);

	}

	@Override
	@Transactional
	public void delete(int playerId) {
		sessionFactory.getCurrentSession().delete(getScore(playerId));

	}

	@Override
	@Transactional
	public Score getScore(int playerId) {

		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		Score score = (Score)sessionFactory.getCurrentSession().get(Score.class, playerId);	
		transaction.commit();
		return score;

	}

	public List<Score> getAllScores() {

		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		List<Score> scores = sessionFactory.getCurrentSession().createQuery("from ScoreBoard").list();

		transaction.commit();

		return scores;
	}

}
