package marketplace;

public class IgnoreFormatting {
    public static boolean equalsIgnoreFormatting(String a, String b) {
        if (a == null || b == null) return false;

        String cleanA = a.trim().replaceAll("\\s+", " ").toLowerCase();
        String cleanB = b.trim().replaceAll("\\s+", " ").toLowerCase();

        return cleanA.equals(cleanB);
    }
}
