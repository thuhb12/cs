/*
8. String to Integer (atoi)
 */
public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("- 42"));
    }

    public int myAtoi(String str) {
        Status status = new Status();
        status.state = State.START;
        for (int i = 0; i < str.length(); i++) {
            transfer(status, str.charAt(i));
            if (status.state == State.END) {
                if (status.sign == -1) {
                    if (status.overflow) {
                        return -2147483648;
                    }
                    if (status.value >= 2147483648L) {
                        return -2147483648;
                    } else {
                        return -1 * (int) status.value;
                    }
                } else {
                    if (status.overflow) {
                        return 2147483647;
                    }
                    if (status.value >= 2147483647L) {
                        return 2147483647;
                    } else {
                        return  (int) status.value;
                    }
                }

            }
        }
        if (status.state == State.NUM) {
            if (status.sign == -1) {
                if (status.overflow) {
                    return -2147483648;
                }
                if (status.value >= 2147483648L) {
                    return -2147483648;
                } else {
                    return -1 * (int) status.value;
                }
            } else {
                if (status.overflow) {
                    return 2147483647;
                }
                if (status.value >= 2147483647L) {
                    return 2147483647;
                } else {
                    return  (int) status.value;
                }
            }
        }
        return 0;
    }

    public static void transfer(Status status, char ch) {

        switch (status.state) {
            case START:
                if (isSign(ch)) {
                    if (ch == '+') {
                        status.state = State.SIGN;
                        status.sign = 1;
                        status.value = 0;
                    } else {
                        status.state = State.SIGN;
                        status.sign = -1;
                        status.value = 0;
                    }
                } else if (is0to9(ch)) {
                    status.state = State.NUM;
                    status.sign = 1;
                    status.value = status.value*10 + Integer.parseInt(ch+"");
                } else if (ch == ' '){
                    status.sign = 0;
                    status.value = 0;
                } else {
                    status.state = State.END;
                    status.value = 0;
                }
                return;
            case SIGN:
                if (isSign(ch)) {
                    if (ch == '+') {
                        status.sign = 1;
                        status.value = 0;
                    } else {
                        status.sign = -1;
                        status.value = 0;
                    }
                    status.state = State.END;
                } else if (is0to9(ch)) {
                    status.state = State.NUM;
                    status.value = status.value*10 + Integer.parseInt(ch+"");
                } else {
                    status.state = State.END;
                    status.value = 0;
                }
                return;
            case NUM:
                if (is0to9(ch)) {
                    long oldvalue = status.value;
                    status.value = status.value*10 + Integer.parseInt(ch+"");
                    if (oldvalue != 0 && !String.valueOf(status.value).equals(String.valueOf(oldvalue)+ch)) {
                        status.overflow = true;
                        status.state = State.END;
                    }
                } else {
                    status.state = State.END;
                }
                return;
        }
    }

    private static boolean isSign(char ch) {
        return ch == '+' || ch == '-';
    }

    private static boolean is0to9(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean is1to9(char ch) {
        return ch >= '1' && ch <= '9';
    }

}

class Status {
    State state;
    long sign;
    long value;
    boolean overflow;
}

enum State {
    START, SIGN, NUM, END
}
