#!/bin/bash

echo "Removendo arquivos .class..."

find . -type f -name "*.class" -print -exec rm -f {} \;

echo "Arquivos .class removidos com sucesso."
