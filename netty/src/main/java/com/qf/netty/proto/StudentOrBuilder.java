// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.qf.netty.proto;

public interface StudentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ceshi.Student)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required string name = 1;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>required string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>required string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional int32 age = 2;</code>
   * @return Whether the age field is set.
   */
  boolean hasAge();
  /**
   * <code>optional int32 age = 2;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>optional string address = 3;</code>
   * @return Whether the address field is set.
   */
  boolean hasAddress();
  /**
   * <code>optional string address = 3;</code>
   * @return The address.
   */
  java.lang.String getAddress();
  /**
   * <code>optional string address = 3;</code>
   * @return The bytes for address.
   */
  com.google.protobuf.ByteString
      getAddressBytes();
}