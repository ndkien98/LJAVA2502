package buoi11.designparttern.observers;

public enum LoginStatus {
    SUCCESS, // trạng thái khi login thành công
    FAILURE, // trạng thái khi login thất bạn
    INVALID, // trạng thái khi login không đúng
    EXPIRED // trạng thái khi tài khoản hết hạn
}
