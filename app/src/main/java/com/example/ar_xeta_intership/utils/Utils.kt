package com.example.ar_xeta_intership.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.google.android.filament.Engine
import com.google.ar.core.Anchor
import io.github.sceneview.ar.node.AnchorNode
import io.github.sceneview.loaders.MaterialLoader
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.node.CubeNode
import io.github.sceneview.node.ModelNode

object Utils {
    val models = mapOf(
        "Cube" to "cube.glb",
        "Sphere" to "cube.glb",
        "Cylinder" to "cube.glb",
        "Cone" to "cube.glb",
        "Torus" to "cube.glb",
        "Pyramid" to "cube.glb",
        "Suzanne" to "cube.glb",
        "Plane" to "cube.glb",
        "Capsule" to "cube.glb",
        "Icosahedron" to "cube.glb"
    )

    fun getModelForModel(model: String): String {
        val modelName = models[model] ?: error("Model not found")
        return "models/$modelName"
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun createAnchorNode(
        engine: Engine,
        modelLoader: ModelLoader,
        materialLoader: MaterialLoader,
        modelInstance: MutableList<ModelInstance>,
        anchor: Anchor,
        model: String
    ): AnchorNode {
        val anchorNode = AnchorNode(engine = engine, anchor = anchor)
        val modelNode = ModelNode(
            modelInstance = modelInstance.apply {
                if (isEmpty()) {
                    this += modelLoader.createInstancedModel(model, 10)
                }
            }.removeLast(),
            scaleToUnits = 0.2f
        ).apply {
            isEditable = true
        }
        val boundingBox = CubeNode(
            engine = engine,
            size = modelNode.extents,
            center = modelNode.center,
            materialInstance = materialLoader.createColorInstance(Color.White)
        ).apply {
            isVisible = false
        }
        modelNode.addChildNode(boundingBox)
        anchorNode.addChildNode(modelNode)

        listOf(modelNode, anchorNode).forEach {
            it.onEditingChanged = { editingTransforms ->
                boundingBox.isVisible = editingTransforms.isNotEmpty()
            }
        }
        return anchorNode
    }

    fun randomModel(): Pair<String, String> {
        val randomKey = models.keys.random()
        return Pair(randomKey, getModelForModel(randomKey))
    }
}
