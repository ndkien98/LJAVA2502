package buoi4;

public class Main3 {

    public static void main(String[] args) {

        int tongSoLan = 100000;
        String textString = "";
        long startTimeTextString = System.currentTimeMillis();
        for (int i = 0; i < tongSoLan; i++) {
            textString += "hello";
        }
        long endTimeTextString = System.currentTimeMillis();
        System.out.println("textString: " + ( endTimeTextString - startTimeTextString));


        StringBuffer textBuffer = new StringBuffer();
        long startTimeTextBuffer = System.currentTimeMillis();
        for (int i = 0; i < tongSoLan; i++) {
            textBuffer.append("hello");
        }
        long endTimeTextBuffer = System.currentTimeMillis();
        System.out.println("startTimeTextBuffer: " + (endTimeTextBuffer - startTimeTextBuffer));


        StringBuilder textStringBuilder = new StringBuilder();
        long startTimeStringBuilder = System.currentTimeMillis();
        for (int i = 0; i < tongSoLan; i++) {
            textStringBuilder.append("hello");
        }
        long endTimeStringBuilder = System.currentTimeMillis();
        System.out.println("textStringBuilder: " + (endTimeStringBuilder - startTimeStringBuilder));

    }
}
