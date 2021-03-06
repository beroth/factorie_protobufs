package edu.umass.cs.iesl.factorie_protobufs.serialization

import cc.factorie.app.nlp.ner._
import cc.factorie.app.nlp.Token
import scala.reflect.ClassTag
import edu.umass.cs.iesl.protos._

/**
 * @author John Sullivan
 */
class NerAnnotation[NER <: NerTag](constructor:((Token, String) => NER))(implicit m:ClassTag[NER]) extends TokenLevelAnnotation {
  val annotation = m.runtimeClass.getName
  val annotationType = AnnotationType.TAG

  def serializeToken(fToken:Token, pToken:TokenBuilder) = {
    val pAnno = indexedAnnotation.setType(annotationType)
    if(fToken.attr.contains[NER]) {
      pAnno.setText(fToken.attr[NER].categoryValue)
    }
    pToken.addAnnotation(pAnno.build())
  }

  def deserializeToken(pToken:ProtoToken, fToken:Token) = {
    fToken.attr += constructor(fToken, pToken.getAnnotation(_methodIndex).getText)
    fToken
  }
}

object BILOUConllNERAnnotation extends NerAnnotation({(t, s) => new BilouConllNerTag(t, s)})
object BILOUOntonotesNERAnnotation extends NerAnnotation({(t, s) => new BilouOntonotesNerTag(t, s)})
object BIOConllNERAnnotation extends NerAnnotation({(t, s) => new BioConllNerTag(t, s)})
object BIOOntonotesNERAnnotation extends NerAnnotation({(t, s) => new BioOntonotesNerTag(t, s)})