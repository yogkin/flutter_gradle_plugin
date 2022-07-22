package com.my.gradle.custom.plugin;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import groovy.util.logging.Log;

/**
 * ASM操作class的类
 */
public class MyClassVisitor extends ClassVisitor {


    private String className;

    private String superName;

    public MyClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public void visit(int version, int access, String className, String signature, String superName, String[] interfaces) {
        super.visit(version, access, className, signature, superName, interfaces);
        this.className = className;
        this.superName = superName;
    }

    @Override
    public MethodVisitor visitMethod(int access, String methodName, String descriptor, String signature, String[] exceptions) {

        MethodVisitor methodVisitor = cv.visitMethod(access, methodName, descriptor, signature, exceptions);
        if (methodName.startsWith("onRestoreInstanceState")) {
            System.out.println("已经插入修改代码: " + className + "." + methodName);
            return new MyMethodVisitor(methodVisitor, className, methodName);
        }
        return methodVisitor;
    }
}
