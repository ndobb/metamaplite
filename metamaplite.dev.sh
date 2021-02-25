#!/bin/sh

PROJECTDIR=/Users/nicdobbins/work/nlp/metamaplite

BIOC=$PROJECTDIR/lib/bioc-1.0.1.jar
LOG4JAPI=$PROJECTDIR/lib/log4j-api-2.1.jar
ANALYZERS=$PROJECTDIR/lib/lucene-analyzers-common-4.10.0.jar
QUERYIES=$PROJECTDIR/lib/lucene-queries-4.10.0.jar
NLP=$PROJECTDIR/lib/nlp-2.4.C.jar
OPENNLPTOOLS=$PROJECTDIR/lib/opennlp-tools-1.5.3.jar
CONTEXT=$PROJECTDIR/lib/context-2012.jar
LOG4JCORE=$PROJECTDIR/lib/log4j-core-2.1.jar
CORE=$PROJECTDIR/lib/lucene-core-4.10.0.jar
QUERYPARSER=$PROJECTDIR/lib/lucene-queryparser-4.10.0.jar
OPENNLPMAXENT=$PROJECTDIR/lib/opennlp-maxent-3.0.3.jar
OPENCSV=$PROJECTDIR/lib/opencsv-2.3.jar
IRUTILS=$PROJECTDIR/lib/irutils-2.0-SNAPSHOT.jar
METAMAPLITE=$PROJECTDIR/target/metamaplite-3.6.1p2.jar

JARSPATH=$ANALYZERS:$CORE:$QUERYPARSER:$OPENNLPTOOLS:$OPENNLPMAXENT:$BIOC:$NLP:$LOG4JAPI:$LOG4JCORE:$CONTEXT:$OPENCSV:$IRUTILS:$METAMAPLITE

# OPENNLP_MODELS=/usr/local/pub/nlp/opennlp/models
OPENNLP_MODELS=$PROJECTDIR/data/models
CONFIGDIR=$PROJECTDIR/config

JVMOPTS="-Den-sent.bin.path=$OPENNLP_MODELS/en-sent.bin \
    -Den-token.bin.path=$OPENNLP_MODELS/en-token.bin \
    -Den-pos-maxent.bin.path=$OPENNLP_MODELS/en-pos-maxent.bin \
    -Dopennlp.en-chunker.bin.path=$OPENNLP_MODELS/en-chunker.bin \
    -Dlog4j.configurationFile=file://$PROJECTDIR/config/log4j2.xml \
    -Dmetamaplite.property.file=$CONFIGDIR/metamaplite.properties \
    -Dmetamaplite.entitylookup.resultlength=1500 \
    -Dmetamaplite.excluded.termsfile=$PROJECTDIR/data/specialterms.txt"

java -cp $PROJECTDIR/target/classes:$PROJECTDIR/build/classes:$PROJECTDIR/classes:$JARSPATH:$CONFIGDIR $JVMOPTS gov.nih.nlm.nls.ner.MetaMapLite $* 

