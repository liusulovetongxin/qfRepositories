// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.qf.netty.proto;

public final class StudentInfo {
  private StudentInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ceshi_Student_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ceshi_Student_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rStudent.proto\022\005ceshi\"5\n\007Student\022\014\n\004nam" +
      "e\030\001 \002(\t\022\013\n\003age\030\002 \001(\005\022\017\n\007address\030\003 \001(\tB%\n" +
      "\022com.qf.netty.protoB\013StudentInfoH\001P\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ceshi_Student_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ceshi_Student_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ceshi_Student_descriptor,
        new java.lang.String[] { "Name", "Age", "Address", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
