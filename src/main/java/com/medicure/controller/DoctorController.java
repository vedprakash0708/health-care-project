@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @PostMapping("/registerDoctor")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    @PutMapping("/updateDoctor/{doctorRegNo}")
    public Doctor updateDoctor(@PathVariable String doctorRegNo, @RequestBody Doctor doctor) {
        // implementation
    }
    
    @GetMapping("/searchDoctor/{doctorName}")
    public List<Doctor> searchDoctor(@PathVariable String doctorName) {
        // implementation
    }
    
    @DeleteMapping("/deletePolicy/{doctorRegNo}")
    public void deleteDoctor(@PathVariable String doctorRegNo) {
        // implementation
    }
}