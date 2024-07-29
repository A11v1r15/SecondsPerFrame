package com.a11v1r15.spf;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SecondsPerFrame implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spf");

	@Override
	public void onInitialize() {
		Random random = new Random();
		String[] s = {"Seconds", "Swords", "Slugs", "Sasquatches", "Stones"};
		String[] f = {"Frame", "Foot", "Furlong", "Fathom", "Freedom", "Fahrenheit"};
		String S = s[random.nextInt(s.length)];
		String F = f[random.nextInt(f.length)];
		LOGGER.info("{} per {}!", S, F);
	}
}