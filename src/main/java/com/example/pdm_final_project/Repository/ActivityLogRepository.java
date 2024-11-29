package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    List<ActivityLog> findByUser(Long userId);
    List<ActivityLog> findByTask(Long taskId);
    List<ActivityLog> findByTimestampBetweenOrderByTimestampDesc(Timestamp start, Timestamp end);
    List<ActivityLog> findByUserUserIdAndTimestampBetweenOrderByTimestampDesc(
        Long userId, Timestamp start, Timestamp end);
}
