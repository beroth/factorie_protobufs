package edu.umass.cs.iesl

/**
 * @author John Sullivan
 */
package object protos {
  type DocumentBuilder = ProtoFac.Document.Builder
  type ProtoDocument = ProtoFac.Document
  type MethodBuilder = ProtoFac.Document.Method.Builder
  type ProtoMethod = ProtoFac.Document.Method
  type AnnotationType = ProtoFac.Document.AnnotationType
  type AnnotationBuilder = ProtoFac.Document.Annotation.Builder
  type TokenBuilder = ProtoFac.Document.Token.Builder

  object AnnotationType {
    val TAG = ProtoFac.Document.AnnotationType.TAG
    val OTHER = ProtoFac.Document.AnnotationType.OTHER
    val BOUNDARY = ProtoFac.Document.AnnotationType.BOUNDARY
    val TEXT = ProtoFac.Document.AnnotationType.TEXT
  }

  def protoMethod = ProtoFac.Document.Method.newBuilder()
  def protoDocument = ProtoFac.Document.newBuilder()
  def protoAnnotation = ProtoFac.Document.Annotation.newBuilder()
  def protoToken = ProtoFac.Document.Token.newBuilder()
}