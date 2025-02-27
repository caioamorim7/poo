#!/bin/bash

# Perguntar qual tarefa deseja testar
read -p "Digite o diretório da tarefa (pressione Enter para testar todas as tarefas): " task_dir

# Perguntar para qual aluno deseja executar os testes
read -p "Digite o diretório do aluno (pressione Enter para testar todos os alunos): " student_dir

# Configurar diretórios base
BASE_DIR="assignments"
JUNIT_JAR="lib/junit-platform-console-standalone-1.11.4.jar"

# Baixar JUnit caso não esteja presente
if [ ! -f "$JUNIT_JAR" ]; then
  echo "Baixando JUnit..."
  mkdir -p lib
  curl -L -o "$JUNIT_JAR" https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
fi

# Identificar as tarefas a serem testadas
if [ -z "$task_dir" ]; then
  tasks=($(ls -d $BASE_DIR/*/))
else
  tasks=("$BASE_DIR/$task_dir/")
fi

# Iterar sobre as tarefas
for task in "${tasks[@]}"; do
  task_name=$(basename "$task")
  echo "Executando testes para a tarefa: $task_name"

  # Identificar os alunos a serem testados
  if [ -z "$student_dir" ]; then
    students=($(ls -d "$task/submissions/"*/))
  else
    students=("$task/submissions/$student_dir/")
  fi

  # Iterar sobre os alunos
  for student in "${students[@]}"; do
    student_name=$(basename "$student")
    echo "Executando testes para o aluno: $student_name"

    # Caminho do código do aluno
    src_dir="$student/src"
    bin_dir="$student/bin"

    # Criar diretório bin se não existir
    mkdir -p "$bin_dir"

    # Compilar código
    javac -cp "$JUNIT_JAR" -d "$bin_dir" "$src_dir"/*.java "$task/test/"*.java
    if [ $? -ne 0 ]; then
      echo "❌ Erro na compilação para $student_name na tarefa $task_name"
      continue
    fi

    # Executar testes
    java -jar "$JUNIT_JAR" --class-path "$bin_dir" --scan-class-path
  done
done

echo "✅ Testes concluídos!"
