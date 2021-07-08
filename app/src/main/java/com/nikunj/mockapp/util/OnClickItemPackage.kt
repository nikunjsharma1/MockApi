package com.nikunj.mockapp.util

import com.nikunj.mockapp.model.ClassesName

interface OnClickItemPackage {
    fun onClick (classesName: ClassesName,position: Int)
}