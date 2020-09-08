package mz.ac.ucmins.Model;

import java.util.List;

public class ResultsReady {
    private String patientname;
    private List<Sample> Samples;


    private class Sample {
        private List<Analysis> analyses;
    }
}
