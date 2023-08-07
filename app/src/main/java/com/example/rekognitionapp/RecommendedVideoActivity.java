package com.example.rekognitionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class RecommendedVideoActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_video);

        webView = findViewById(R.id.webView);

        // MainActivity에서 전달한 감정 데이터를 가져옴
        String detectedEmotion = getIntent().getStringExtra("emotion");

        // 감정에 따라 추천되는 YouTube 비디오 검색
        String recommendedVideoQuery = "동영상"; // 기본값
        if (detectedEmotion != null) {
            recommendedVideoQuery = getRecommendedVideoQuery(detectedEmotion);
        }
        String youtubeSearchUrl = "https://youtu.be/" + recommendedVideoQuery;

        // WebView에 YouTube 검색 결과 표시
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(youtubeSearchUrl);
    }

    // 감정에 따라 추천되는 YouTube 비디오 검색 쿼리 생성
    private String getRecommendedVideoQuery(String detectedEmotion) {
        // 감정에 따라 원하는 검색 쿼리를 반환하는 로직 구현
        // 예시: 행복한 감정에는 "재미있는 동영상", 슬픈 감정에는 "감동적인 동영상" 등
        String recommendedVideoQuery = " 동영상"; // 기본값
        switch (detectedEmotion) {
            case "HAPPY":
                recommendedVideoQuery = "HuK4H6CjyL0";
                break;
            case "SAD":
                recommendedVideoQuery = "7PQqLtdDC2A";
                break;
            case "ANGRY":
                recommendedVideoQuery = "0rMhYX9xCR4";
                break;
            case "SURPRISED":
                recommendedVideoQuery = "M0aGDXSUvoY";
                break;
            case "DISGUSTED":
                recommendedVideoQuery = "8pXX2kZNORA";
                break;
            case "CONFUSED":
                recommendedVideoQuery = "ebXUK3UY_j4";
                break;
            case "CALM":
                recommendedVideoQuery = "mGVdGNDhwdQ";
            default:
                break;
        }
        return recommendedVideoQuery;
    }
    }
