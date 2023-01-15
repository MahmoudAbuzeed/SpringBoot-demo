package Mahmoud.dev.demo.model;

import java.time.LocalDateTime;

public record LiveStream(String id, String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate) {
    public LiveStream {
        if( id == null){
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
