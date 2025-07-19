package com.yhkoo.architecture_sample_android.domain.base

sealed class DomainException(message: String) : Exception(message)

class NetworkException(message: String = "네트워크 오류가 발생했습니다.") : DomainException(message)
class EmptyDataException(message: String = "데이터가 비어있습니다.") : DomainException(message)
class UnknownException(message: String = "알 수 없는 오류가 발생했습니다.") : DomainException(message) 