rem call mvn clean install
call java -cp target/memory-manage-1.0.jar jmp.training.memory.manage.OOMHeapTest -Xmx128M -XX:-UseGCOverheadLimit