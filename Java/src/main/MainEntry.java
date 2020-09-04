package src.main;

import graphql.ExecutionResult;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.GraphQL;

import java.util.LinkedList;
import java.util.concurrent.CompletionStage;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;
public class MainEntry {
    public MainEntry() {

    }

    public static void main(String[] args) {
        String schema = "type Query{hello: String}";
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))

                .build();

//        GraphQLSchema.newSchema().query()
//        CompletionStage;
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.
                makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);


        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{hello}");

        System.out.println(executionResult.getData().toString());
    }
}
