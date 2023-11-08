package com.example.designpattren.decoratorpattern.practice1

class UserNameValidator(private val userRepository: UserRepository) :
    UserRepository by userRepository {


    override fun setUserName(userName: String, user: String) {
        require(userName.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            "user name is not of valid length"
        }
        userRepository.setUserName(userName, user)
    }

    companion object {
        private const val MAX_NAME_LENGTH = 20
        private const val MIN_NAME_LENGTH = 4
    }
}