package comparator;

import java.util.Comparator;
import java.util.Locale;

public class NaturalOrderComparator implements Comparator<String> {

    public static NaturalOrderComparator naturalOrder() {
        return new NaturalOrderComparator();
    }

    public int compare(String s1, String s2) {
        if (isNotEmptyOrNull(s1) && isNotEmptyOrNull(s2)) {
            return compareTokens(removeDigitSeparators(s1), removeDigitSeparators(s2));
        } else if (s1 == null || s1.length() == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    private int compareTokens(String s1, String s2) {
        String tokenOne = getToken(s1);
        String tokenTwo = getToken(s2);

        String remainderOne = getRemainder(tokenOne, s1);
        String remainderTwo = getRemainder(tokenTwo, s2);
        int result = comparePart(removePadding(tokenOne),removePadding(tokenTwo));
        if (result == 0) {
            if ((isNotEmptyOrNull(remainderOne) || isNotEmptyOrNull(remainderTwo))) {
                return compare(remainderOne, remainderTwo);
            } else {
                return compareTo(tokenOne, tokenTwo);
            }
        } else {
            return result;
        }
    }

    private int comparePart(String partOne, String partTwo) {
        String cleanTokenOne = removePadding(partOne);
        String cleanTokenTwo = removePadding(partTwo);

        boolean isNumberFirst = isNumber(cleanTokenOne);
        boolean isNumberSecond = isNumber(cleanTokenTwo);
        boolean isSpecialCharacterFirst = isSpecialCharacter(cleanTokenOne);
        boolean isSpecialCharacterSecond = isSpecialCharacter(cleanTokenTwo);

        if (isNumberFirst && isNumberSecond) {
            return Double.valueOf(cleanTokenOne).compareTo(Double.valueOf(cleanTokenTwo));
        } else if (isSpecialCharacterFirst && isSpecialCharacterSecond) {
            return compareTo(cleanTokenOne, cleanTokenTwo);
        } else if (isNumberFirst && isSpecialCharacterSecond) {
            return -1;
        } else if(isSpecialCharacterFirst && isNumberSecond) {
            return 1;
        } else if (isNumberFirst || isSpecialCharacterFirst) {
            return -1;
        } else if (isNumberSecond || isSpecialCharacterSecond) {
            return 1;
        } else {
            return compareTo(cleanTokenOne, cleanTokenTwo);
        }
    }

    private int compareTo(String a, String b) {
        int result = a.compareToIgnoreCase(b);
        if (result == 0) {
            result = a.compareTo(b);
            if (result == 0) {
                return result;
            } else {
                if (isUpperCase(a) && isUpperCase(b)) {
                    return result;
                } else if (isUpperCase(a)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            return result;
        }
    }

    private boolean isUpperCase(String s) {
        String upperCase = s.toUpperCase(Locale.ROOT);
        return upperCase.equals(s);
    }

    private boolean isNumber(String c) {
        try {
            Double.valueOf(c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String getToken(String s) {
        StringBuilder str = new StringBuilder();
        if (s != null) {
            if (isDecimal(s)) {
                return s;
            } else {
                int i = 0;
                if (Character.isDigit(s.charAt(i))) {
                    while (i < s.length() && (Character.isDigit(s.charAt(i)))) {
                        str.append(s.charAt(i));
                        i++;
                    }
                } else {
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();
    }

    private String removePadding(String s) {
        int i = 0;
        StringBuilder str = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) != '0' && str.length() == 0 || str.length() > 0) {
                str.append(s.charAt(i));
            } else {
                if (i == s.length() - 1 || i + 1 < s.length() && !Character.isDigit(s.charAt(i + 1))) {
                    str.append(s.charAt(i));
                }
            }
            i++;
        }
        return str.toString();
    }

    private String getRemainder(String a, String b) {
        if (!a.equals("") && !b.equals("")) {
            if (a.charAt(0) == b.charAt(0)) {
                return getRemainder(a.substring(1), b.substring(1));
            } else {
                return b;
            }
        } else if (!a.equals("")) {
            return a;
        } else {
            return b;
        }
    }

    private String removeDigitSeparators(String s) {
        if (isDigitGroupSeparated(s)) {
            return s.replace(",", "");
        }
        return s;
    }

    private boolean isDecimal(String s) {
        return s.matches("[0-9]((.)[0-9]*)");
    }

    private boolean isDigitGroupSeparated(String s) {
        return s.matches("[0-9]((,)[0-9]*)*(\\.[0-9]*)?");
    }

    private boolean isSpecialCharacter(String s) {
        return s.matches("[^A-Za-z0-9]");
    }

    private boolean isNotEmptyOrNull(String s) {
        return s != null && s.length() != 0;
    }
}
