package com.my.gradle.custom.plugin;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import groovyjarjarasm.asm.Opcodes;

/**
 * ASM操作Method方法的类
 */
public class MyMethodVisitor extends MethodVisitor {
    MyMethodVisitor(MethodVisitor methodVisitor, String className, String methodName) {
        super(Opcodes.ASM5, methodVisitor);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        //插入关键代码
        mv.visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 1);
        mv.visitTypeInsn(org.objectweb.asm.Opcodes.INSTANCEOF, "com/my/gradle/plugin/demo/FlutterSplashView$SavedState");
        Label label0 = new Label();
        mv.visitJumpInsn(org.objectweb.asm.Opcodes.IFNE, label0);
        mv.visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 0);
        mv.visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 1);
        mv.visitMethodInsn(org.objectweb.asm.Opcodes.INVOKESPECIAL, "android/widget/FrameLayout", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", false);
        mv.visitInsn(org.objectweb.asm.Opcodes.RETURN);
        mv.visitLabel(label0);
    }
}
