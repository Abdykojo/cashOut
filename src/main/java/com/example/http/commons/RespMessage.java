package com.example.http.commons;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RespMessage {
    OK("200", "Пользователь найден"),
    NOT_MONEY ("103","Недостаточно средств для списания"),
    FOR_PROCESSING("249", "Платеж находится в процессе обработки"),
    QID_IS_PRESENT("420", "Дублирование платежа"),
    NULL("440", "Недостаточно средств для списания"),
    COMMITTED("250","Платежное поручение успешно создано"),
    BAD_REQUEST("301", "Неправильные реквизиты"),
    USER_NOT_FOUND("302", "Пользователь не найден"),
    SERVICE_NOT_RABOTAT("400", "Недокументированная ошибка"), //controlleradvice checkstyle
    NOT_AUTH("304","Авторизация не прошла"),
    NOT_REGISTER("303", "Регистраия не прошла"),
    CREDIT_LIMITS("310","Данные кредита не прошли проверку, измените срок или сумму"),
    LARGE_SUM("202", "Сумма превышает остаток по кредиту, измените сумму оплаты");
    private String status;
    private String message;

}
