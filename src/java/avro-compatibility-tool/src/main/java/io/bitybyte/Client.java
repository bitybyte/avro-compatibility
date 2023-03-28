package io.bitybyte;

import com.hotels.avro.compatibility.Compatibility;
import org.apache.avro.Schema;

public class Client {
    public static void main(String[] args) {
    }
    public static boolean isCompatibleMutualRead(String oldSchemaStr, String newSchemaStr) {
        Schema oldSchema = new Schema.Parser().parse(oldSchemaStr);
        Schema newSchema = new Schema.Parser().parse(newSchemaStr);
        return Compatibility.checkThat(oldSchema)
                .mutualReadWith(newSchema).isCompatible();
    }

    public static boolean isCompatibleNewReadsOld(String oldSchemaStr, String newSchemaStr) {
        Schema oldSchema = new Schema.Parser().parse(oldSchemaStr);
        Schema newSchema = new Schema.Parser().parse(newSchemaStr);
        return Compatibility.checkThat(oldSchema)
                .canBeReadBy(newSchema).isCompatible();
    }

    public static boolean isCompatibleOldReadsNew(String oldSchemaStr, String newSchemaStr) {
        Schema oldSchema = new Schema.Parser().parse(oldSchemaStr);
        Schema newSchema = new Schema.Parser().parse(newSchemaStr);
        return Compatibility.checkThat(oldSchema)
                .canRead(newSchema).isCompatible();
    }
}
