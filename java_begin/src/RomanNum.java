public enum RomanNum {
    I("1"),II("2"),III("3"),
    IV("4"),V("5"),VI("6"),
    VII("7"),VIII("8"),IX("9"),
    X("10");

    public String ArabicNum;

    RomanNum(String ArabicNum) {
        this.ArabicNum = ArabicNum;
    }
    public String getArabicNum() {
        return ArabicNum;
    }
   // public String code;

   // RomanNum(String code) {
    //    this.code = code;

}
