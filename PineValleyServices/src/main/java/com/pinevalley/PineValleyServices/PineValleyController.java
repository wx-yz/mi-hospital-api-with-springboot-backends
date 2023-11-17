package com.pinevalley.PineValleyServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

class DoctorType {
    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    String doctorType;
}

@RestController
public class PineValleyController {

    Logger logger = LoggerFactory.getLogger(PineValleyController.class);
    @PostMapping(
            value = "/",
            consumes = "application/json",
            produces = "application/json"
    )
    public DoctorsList pineValleyDoctors(@RequestBody DoctorType dType) {
        ArrayList<Doctor> pDoctors = new ArrayList<Doctor>();
        pDoctors.add(new Doctor("John Mathew", "07:30 AM", "pineValley"));
        pDoctors.add(new Doctor("Roma Katherine", "04:30 PM", "pineValley"));

        // Not equals. Either we got a different value or no value. Send all doctors
        if (!dType.doctorType.equals("Ophthalmologist")) {
            logger.info("Getting all doctors");
            pDoctors.add(new Doctor("Karol Naliaka", "05:30 PM", "pineValley"));
            pDoctors.add(new Doctor("Raschelle Alba", "06:30 PM", "pineValley"));
        } else {
            logger.info("Getting all doctors for speciality: " + dType.doctorType);
        }
        DoctorsList dList = new DoctorsList(pDoctors);
        String docStr = pDoctors.stream().map(Object::toString).collect(Collectors.joining(", "));
        logger.info("Doctors: " + docStr);
        return dList;
    }
}
