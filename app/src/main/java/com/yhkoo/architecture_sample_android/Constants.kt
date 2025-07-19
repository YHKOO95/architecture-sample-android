package com.yhkoo.architecture_sample_android

object Constants {
    // Network
    const val BASE_URL = "https://api.punkapi.com"
    const val NETWORK_TIMEOUT = 15L
    
    // Error Messages
    const val ERROR_NETWORK = "네트워크 오류가 발생했습니다."
    const val ERROR_EMPTY_DATA = "맥주 정보를 찾을 수 없습니다."
    const val ERROR_UNKNOWN = "알 수 없는 오류가 발생했습니다."
    const val ERROR_LOAD_FAILED = "데이터를 불러오는데 실패했습니다."
    
    // UI Messages
    const val MESSAGE_RETRY = "다시 시도해주세요."
    const val MESSAGE_LOADING = "로딩 중..."
} 