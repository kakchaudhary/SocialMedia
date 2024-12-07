package com.example.SocialMedia.Utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeUtils {
	public static String getRelativeTime(LocalDateTime timestamp) {
		Duration duration = Duration.between(timestamp, LocalDateTime.now());

		if (duration.toMinutes() < 1) {
			return "just now";
		} else if (duration.toMinutes() < 60) {
			return duration.toMinutes() + "m ago";
		} else if (duration.toHours() < 24) {
			return duration.toHours() + "h ago";
		} else {
			return duration.toDays() + "d ago";
		}
	}
}
