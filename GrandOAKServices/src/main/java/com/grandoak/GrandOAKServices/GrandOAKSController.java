package com.grandoak.GrandOAKServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

class DoctorsList {
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    DoctorsList(ArrayList<Doctor> dList) {
        this.doctors = dList;
    }

    ArrayList<Doctor> doctors;
}

@RestController
public class GrandOAKSController {

    Logger logger = LoggerFactory.getLogger(GrandOAKSController.class);

    @GetMapping("/grandOaks/doctors/{doctorType}")
    public DoctorsList grandOakDoctors(@PathVariable String doctorType) {
        ArrayList<Doctor> gDoctors = new ArrayList<Doctor>();
        logger.info("Getting all doctors for speciality: " + doctorType);
        if (doctorType.equals("Ophthalmologist")) {
            gDoctors.add(new Doctor("John Mathew", "03:30 PM", "Grand Oak"));
            gDoctors.add(new Doctor("Allan Silvester", "04:30 PM", "Grand Oak"));
            String docStr = gDoctors.stream().map(Object::toString).collect(Collectors.joining(", "));
            logger.info("Specialists: " + docStr);
        }
        DoctorsList dList = new DoctorsList(gDoctors);
        return dList;
    }
}
