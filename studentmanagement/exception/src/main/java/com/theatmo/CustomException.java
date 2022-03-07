package com.theatmo;

public class CustomException extends RuntimeException {

	public CustomException(String message) {
		super(message);
	}

	public static class RecordNotfoundException extends CustomException {

		public RecordNotfoundException(String message) {
			super(message);
		}
	}

	public static class RollNumberAlreadyExistException extends CustomException {

		public RollNumberAlreadyExistException(String message) {
			super(message);
		}
	}

	public static class DateNotValidException extends CustomException {

		public DateNotValidException(String message) {
			super(message);
		}
	}

	public static class SQLSyntaxErrorException extends CustomException {

		public SQLSyntaxErrorException(String message) {
			super(message);
		}
	}

	public static class DetailsAlreadyFoundException extends CustomException {

		public DetailsAlreadyFoundException(String message) {
			super(message);
		}
	}
}