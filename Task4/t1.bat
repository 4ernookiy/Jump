rem call mvn clean install
java -cp target/memory-manage-1.0.jar jmp.training.memory.manage.Main -Xmx256M -Xms256M -XX:-UseGCOverheadLimit