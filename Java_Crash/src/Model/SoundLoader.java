package Model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundLoader {
	
	static File theme;
	static File breakBox;	
	static File akuBox;
	static File enemyHit;
	static File wumpa;
	static File crystal;
	static File spin;
	static File akuVanish;
	static File gameOver;
	static File invincible;
	static File tntBox;
	static File tntexplosiion;
	static File selection;
	static File endLevel;
	static File loading;

	private static Clip cTheme;
	private static Clip cGameOver;
	private static Clip cWumpa;
	private static Clip cBreakBox;
	private static Clip cAkuBox;
	private static Clip cEnemyHit;
	private static Clip cCrystal;
	private static Clip cspin;
	private static Clip cAkuVanish;
	private static Clip cInvincible;
	private static Clip cTntBox;
	private static Clip cTntExplosion;
	private static Clip cSelection;
	private static Clip cEndLevel;
	private static Clip cLoading;
	
	private static AudioFormat format;
	static DataLine.Info info;
	static AudioInputStream stream;
	public SoundLoader() {
		info = new DataLine.Info(Clip.class, format);
		theme = new File("sounds/CrashTheme.wav");
		breakBox = new File("sounds/BreakBox.wav");
		akuBox = new File("sounds/AkuBox.wav");
		enemyHit = new File("sounds/Enemyhit.wav");
		wumpa = new File("sounds/SoundWumpa.wav");
		crystal = new File("sounds/Crystal.wav");
		spin = new File("sounds/SpinSound.wav");
		akuVanish = new File("sounds/AkuVanish.wav");
		gameOver = new File("sounds/GameOver.wav");
		invincible = new File("sounds/Crash_Bandicoot_Invincible.wav");
		tntBox = new File("sounds/tntSound.wav");
		selection = new File("sounds/selectionMenu.wav");
		endLevel = new File("sounds/endLevel.wav");
		tntexplosiion = new File("sounds/tntexplosive.wav");
		loading = new File("sounds/Loading.wav");
	}
	
  public void playTheme() {
	 try {
			stream = AudioSystem.getAudioInputStream(theme);
			info = new DataLine.Info(Clip.class, format);
			cTheme = (Clip) AudioSystem.getLine(info);
			cTheme.open(stream);
			cTheme.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void stopTheme() {
	  cTheme.stop();
  }
  
  public void playLoading() {
	  try {
			stream = AudioSystem.getAudioInputStream(loading);
			info = new DataLine.Info(Clip.class, format);
			cLoading = (Clip) AudioSystem.getLine(info);
			cLoading.open(stream);
			cLoading.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void stopLoading() {
	  cLoading.stop();
  }
  
  public void playEndLevel() {
	  try {
			stream = AudioSystem.getAudioInputStream(endLevel);
			info = new DataLine.Info(Clip.class, format);
			cEndLevel = (Clip) AudioSystem.getLine(info);
			cEndLevel.open(stream);
			cEndLevel.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void stopEndlevel() {
	  cEndLevel.stop();
  }
  
  
  public void playTnt() {
	  try {
			stream = AudioSystem.getAudioInputStream(tntBox);
			info = new DataLine.Info(Clip.class, format);
			cTntBox = (Clip) AudioSystem.getLine(info);
			cTntBox.open(stream);
			cTntBox.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playTntExplosion() {
	  try {
			stream = AudioSystem.getAudioInputStream(tntexplosiion);
			info = new DataLine.Info(Clip.class, format);
			cTntExplosion = (Clip) AudioSystem.getLine(info);
			cTntExplosion.open(stream);
			cTntExplosion.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playInvincible() {
		 try {
				stream = AudioSystem.getAudioInputStream(invincible);
				info = new DataLine.Info(Clip.class, format);
				cInvincible = (Clip) AudioSystem.getLine(info);
				cInvincible.open(stream);
				cInvincible.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
  }
  
  public void stopInvincible() {
	  cInvincible.stop();
  }
  
  public void playSelection() {
		 try {
				stream = AudioSystem.getAudioInputStream(selection);
				info = new DataLine.Info(Clip.class, format);
				cSelection = (Clip) AudioSystem.getLine(info);
				cSelection.open(stream);
				cSelection.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
  }
  
  public void playGameOver() {
		 try {
				stream = AudioSystem.getAudioInputStream(gameOver);
				info = new DataLine.Info(Clip.class, format);
				cGameOver = (Clip) AudioSystem.getLine(info);
				cGameOver.open(stream);
				cGameOver.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
  }

  public void stopGameOver() {
	  cGameOver.stop();
  }
  
  public void playBrakeBox() {
	  try {
			stream = AudioSystem.getAudioInputStream(breakBox);
			info = new DataLine.Info(Clip.class, format);
			cBreakBox = (Clip) AudioSystem.getLine(info);
			cBreakBox.open(stream);
			cBreakBox.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playAkuBox() {
	  try {
			stream = AudioSystem.getAudioInputStream(akuBox);
			info = new DataLine.Info(Clip.class, format);
			cAkuBox = (Clip) AudioSystem.getLine(info);
			cAkuBox.open(stream);
			cAkuBox.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playEnemyHit() {
	  try {
			stream = AudioSystem.getAudioInputStream(enemyHit);
			info = new DataLine.Info(Clip.class, format);
			cEnemyHit = (Clip) AudioSystem.getLine(info);
			cEnemyHit.open(stream);
			cEnemyHit.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playWumpa() {
	  try {
			stream = AudioSystem.getAudioInputStream(wumpa);
			info = new DataLine.Info(Clip.class, format);
			cWumpa = (Clip) AudioSystem.getLine(info);
			cWumpa.open(stream);
			cWumpa.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playCrystal() {
	  try {
			stream = AudioSystem.getAudioInputStream(crystal);
			info = new DataLine.Info(Clip.class, format);
			cCrystal = (Clip) AudioSystem.getLine(info);
			cCrystal.open(stream);
			cCrystal.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
   
  public void playSpin() {
	  try {
			stream = AudioSystem.getAudioInputStream(spin);
			info = new DataLine.Info(Clip.class, format);
			cspin = (Clip) AudioSystem.getLine(info);
			cspin.open(stream);
			cspin.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
  
  public void playAkuVanish() {
	  try {
			stream = AudioSystem.getAudioInputStream(akuVanish);
			info = new DataLine.Info(Clip.class, format);
			cAkuVanish = (Clip) AudioSystem.getLine(info);
			cAkuVanish.open(stream);
			cAkuVanish.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
  }
   
}