package com.gamebuilder.commands;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamebuidler.readouts.GameTime;

public class TestTimerCommand {

	@Mock
	private GameTime gameTime;
	
	@Mock
	private TimerCommand timerCommand;
	
	@Test
	public void TestTimer() {
		gameTime = Mockito.mock(GameTime.class);
		timerCommand  = new TimerCommand(gameTime);
		Mockito.when(gameTime.getText()).thenReturn("01:00");
		Mockito.when(gameTime.getTime()).thenReturn(5000);
		timerCommand.execute();
		assertEquals("00:05", timerCommand.getText());
	}

}
