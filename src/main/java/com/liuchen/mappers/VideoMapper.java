package com.liuchen.mappers;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.blocks.Video;
import com.liuchen.models.dto.ArticleBlockDto;
import com.liuchen.models.dto.VideoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.liuchen.mappers
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 10:38 AM
 * @Version: v1.0
 */

@Data
public class VideoMapper {

    public List<ArticleBlockDto> videosToDto(List<Video> videosDB){

        List<ArticleBlockDto> videoDtos = new ArrayList<>();
        for(int i = 0; i < videosDB.size(); i++){
            VideoDto videoDto = new VideoDto();
            videoDto.setVid(videosDB.get(i).getVid());
            videoDto.setVideo(videosDB.get(i).getVideo());
            videoDtos.add(videoDto);
        }
        return videoDtos;
    }

    public List<Video> saveVideo(List<Video> videoList, Article articleDB){
        List<Video> videoListDB = new ArrayList<>();
        for(int i = 0; i < videoList.size(); i++){
            Video video = new Video();
            video.setSortedIndex(i);
            video.setVideo(videoList.get(i).getVideo());
            video.setArticle(articleDB);
            videoListDB.add(video);
        }
        return videoListDB;
    }

}
