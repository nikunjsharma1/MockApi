package com.nikunj.mockapp.util

import com.nikunj.mockapp.local.ClassesEntity

interface OnClickItemDelete {
    fun onClick (classesEntity: ClassesEntity,position: Int)
}