package com.oosd.model;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestTimerReadout {

	@Mock
	private TimerReadout timerReadout;
	
	@Test
	public void test() {
	    timerReadout = new TimerReadout();
	    ActionEvent mockEvent = Mockito.mock(ActionEvent.class);
	    
	    timerReadout.actionPerformed(mockEvent);
	    
	    assertEquals(1, timerReadout.getTimerSeconds());
	}

}
