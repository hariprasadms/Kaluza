package data;
import java.util.ArrayList;
import java.util.List;

public class JourneyData {
    private static String expected_Type;
    private static List<String> modes;

    public static String getExpected_Type() {
        expected_Type = "Tfl.Api.Presentation.Entities.JourneyPlanner.DisambiguationResult, Tfl.Api.Presentation.Entities";
        return expected_Type;
    }

    public static void setExpected_Type(String expected_Type) {
        JourneyData.expected_Type = expected_Type;
    }

    public static void setModes(List<String> modes) {
        JourneyData.modes = modes;
    }

    public static List<String> getModes() {
        modes = new ArrayList<>();
        modes.add("Bus");
        modes.add("Bus");
        return modes;
    }
}
