package calculator.constant;

public enum ErrorMsg {
    NEGATIVE_NUMBER("양의 정수여야 합니다."),
    EMPTY_STRING("공백은 계산할 수 없습니다."),
    INVALID_NUMBER("유효하지 않은 숫자입니다."),
    MULTIPLE_CUSTOM_DELIMITERS("커스텀 구분자는 하나만 입력할 수 있습니다."),
    EMPTY_DELIMITER("구분자 내부에 값이 없습니다.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
