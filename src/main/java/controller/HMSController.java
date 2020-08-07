package controller;

import model.Booking;
import model.Doctor;
import model.Patient;
import model.Time;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class HMSController {

    @Autowired
    private SessionFactory sessionFactory;

    // patient
    @CrossOrigin
    @RequestMapping(path = "/patients", method = RequestMethod.GET)
    public List<Patient> getPatients(){
        return this.sessionFactory.getCurrentSession().createQuery("from Patient").list();

    }

    @CrossOrigin
    @RequestMapping(path = "/patients", method = RequestMethod.POST)
    public int add(@RequestBody Patient patient){
        this.sessionFactory.getCurrentSession().saveOrUpdate(patient);
        return patient.getId();
    }

    @CrossOrigin
    @RequestMapping(path = "/patients/{id}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable int id){
        Query query =this.sessionFactory.getCurrentSession()
                .createQuery("from Patient where id=:id");
        query.setInteger("id", id);

        Patient patient = (Patient) query.uniqueResult();

        this.sessionFactory.getCurrentSession().delete(patient);
    }

    //doctor
    @CrossOrigin
    @RequestMapping(path = "/doctors", method = RequestMethod.GET)
    public List<Doctor> getDoctor(){
        return this.sessionFactory.getCurrentSession().createQuery("from Doctor").list();

    }

    @CrossOrigin
    @RequestMapping(path = "/doctors", method = RequestMethod.POST)
    public int add(@RequestBody Doctor doctor){
        this.sessionFactory.getCurrentSession().saveOrUpdate(doctor);
        return doctor.getId();
    }

    @CrossOrigin
    @RequestMapping(path = "/doctors/{id}", method = RequestMethod.DELETE)
    public void deleteDoctor(@PathVariable int id){
        Query query =this.sessionFactory.getCurrentSession()
                .createQuery("from Doctor where id=:id");
        query.setInteger("id", id);

        Doctor doctor = (Doctor) query.uniqueResult();

        this.sessionFactory.getCurrentSession().delete(doctor);
    }

    //time
    @CrossOrigin
    @RequestMapping(path = "/times", method = RequestMethod.GET)
    public List<Time> getTime(){
        return this.sessionFactory.getCurrentSession().createQuery("from Time").list();

    }

    @CrossOrigin
    @RequestMapping(path = "/times", method = RequestMethod.POST)
    public int add(@RequestBody Time time){
        this.sessionFactory.getCurrentSession().saveOrUpdate(time);
        return time.getId();
    }

    @CrossOrigin
    @RequestMapping(path = "/times/{id}", method = RequestMethod.DELETE)
    public void deleteTime(@PathVariable int id){
        Query query =this.sessionFactory.getCurrentSession()
                .createQuery("from Time where id=:id");
        query.setInteger("id", id);

        Time time = (Time) query.uniqueResult();

        this.sessionFactory.getCurrentSession().delete(time);
    }

    //booking
    @CrossOrigin
    @RequestMapping(path = "/bookings", method = RequestMethod.GET)
    public List<Booking> getBooking(){
        return this.sessionFactory.getCurrentSession().createQuery("from Booking").list();

    }

    @CrossOrigin
    @RequestMapping(path = "/bookings", method = RequestMethod.POST)
    public int add(@RequestBody Booking booking){
        this.sessionFactory.getCurrentSession().saveOrUpdate(booking);
        return booking.getId();
    }

    @CrossOrigin
    @RequestMapping(path = "/bookings/{id}", method = RequestMethod.DELETE)
    public void deleteBooking(@PathVariable int id){
        Query query =this.sessionFactory.getCurrentSession()
                .createQuery("from Booking where id=:id");
        query.setInteger("id", id);

        Booking booking = (Booking) query.uniqueResult();

        this.sessionFactory.getCurrentSession().delete(booking);
    }





    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
