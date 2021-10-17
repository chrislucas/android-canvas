package com.br.sampleeyetracking.feature.facedetection.config

import com.google.mlkit.vision.face.FaceDetectorOptions


/**
 * Face Detection Concepts
 * https://developers.google.com/ml-kit/vision/face-detection/face-detection-concepts
 *
 * */

val highAccuracyOptions = FaceDetectorOptions.Builder()
    .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
    .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
    .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
    .build()

val realTimeOptions = FaceDetectorOptions.Builder()
    .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
    .build()
