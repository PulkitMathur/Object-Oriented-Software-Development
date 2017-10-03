package com.gamebuilder.observers;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class GameObservable implements Observable {
	
	private ArrayList<Observer> observerList;
	
	private static Logger gameObservableLog = Logger.getLogger("gameObservableLogger");
	
	public GameObservable(){
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer o) {
		try{
			observerList.add(o);
		}catch(NullPointerException e){
			gameObservableLog.error("Attempt to add null observer " + e.getLocalizedMessage());
		}
	}

	@Override
	public void unregister(Observer o) {
		int i = observerList.indexOf(o);
		if(i >= 0)
			observerList.remove(i);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observerList){
			o.update();
		}
	}
	
	public void frameChange(){
		notifyObservers();
	}

}
