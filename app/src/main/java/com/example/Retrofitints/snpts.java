package com.example.Retrofitints;
import com.example.Retrofitints.THUMBNAILS;

public class snpts {
    
      
            public String publishedAt;
            public String channelId;
            public String title;
            public String description;
            public THUMBNAILS thumbnails;

            public snpts(
                    String publishedAt,
                    String channelId,
                    String title,
                    String description,
                    THUMBNAILS thmbnails) {
                this.publishedAt = publishedAt;
                this.channelId = channelId;
                this.title = title;
                this.description = description; 
                this.thumbnails = thmbnails;
            }

            

            public String getPublishedAt() {
                return this.publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getChannelId() {
                return this.channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public THUMBNAILS getThumbnails() {
                return this.thumbnails;
            }

            public void setThumbnails(THUMBNAILS thumbnails) {
                this.thumbnails = thumbnails;
            }
        }

        
    


