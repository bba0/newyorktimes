package com.example.bba0.newyorktimes.data;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by bba0 on 2017. 5. 3..
 */

@Data
public class NewYorkTimesData {
    String status;
    int num_results;
    ArrayList<NewYorkTimesResultData> results;

    @Data
    public static class NewYorkTimesResultData {
        String section;
        String subsection;
        String title;
        String url;
        ArrayList<MultimediaData> multimedia;
        String short_url;

        public MultimediaData getImageData() {
            if (multimedia == null || multimedia.size() == 0) {
                return null;
            }
            if (multimedia.size() >= 3) {
                return multimedia.get(2);
            } else {
                return multimedia.get(multimedia.size() - 1);
            }
        }

        public ImageType getImageType() {
            if (getImageData() != null && getImageData().getWidth() >= getImageData().getHeight()) {
                return ImageType.LANDSCAPE;
            } else {
                return ImageType.PORTRAIT;
            }
        }

        public enum ImageType {
            PORTRAIT, LANDSCAPE,
        }

    }

    @Data
    public static class MultimediaData {
        String url;
        String format;
        int height;
        int width;
        String type;

    }
}
