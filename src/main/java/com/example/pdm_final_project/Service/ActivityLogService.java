package com.example.pdm_final_project.Service;

//import com.example.pdm_final_project.Entity.ActivityLog;
//import com.example.pdm_final_project.Repository.ActivityLogRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Optional;

@Service
public class ActivityLogService {

//    @Autowired
//    private ActivityLogRepository activityLogRepository;
//
//    public List<ActivityLog> getAllActivityLogs() {
//        return activityLogRepository.findAll();
//    }
//
//    public Optional<ActivityLog> getActivityLogById(Long id) {
//        return activityLogRepository.findById(id);
//    }
//
//    public List<ActivityLog> getActivityLogsByUser(Long userId) {
//        return activityLogRepository.findByUser(userId);
//    }
//
//    public ActivityLog createActivityLog(ActivityLog activityLog) {
//        return activityLogRepository.save(activityLog);
//    }
//
//    public ActivityLog updateActivityLog(Long id, ActivityLog activityLogDetails) {
//        Optional<ActivityLog> activityLog = activityLogRepository.findById(id);
//        if (activityLog.isPresent()) {
//            ActivityLog existingLog = activityLog.get();
//            existingLog.setAction(activityLogDetails.getAction());
//            existingLog.setDetails(activityLogDetails.getDetails());
//            existingLog.setTimestamp(activityLogDetails.getTimestamp());
//            existingLog.setUser(activityLogDetails.getUser());
//            existingLog.setTask(activityLogDetails.getTask());
//            return activityLogRepository.save(existingLog);
//        }
//        return null;
//    }
//
//    public void deleteActivityLog(Long id) {
//        activityLogRepository.deleteById(id);
//    }
}
