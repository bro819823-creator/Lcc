package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.DiagramItem
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EducationalDiagramCard(
    diagram: DiagramItem,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "🖼️ ${diagram.title}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = diagram.titleHindi,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Visual Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .background(Color(0xFF0F172A), RoundedCornerShape(12.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                DiagramCanvasRenderer(type = diagram.type)
            }

            // Labels List
            Text(
                text = "Key Components & Labels:",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                diagram.labels.forEach { label ->
                    SuggestionChip(
                        onClick = {},
                        label = { Text(label, fontSize = 12.sp) },
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                }
            }

            Text(
                text = diagram.descriptionHinglish,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun DiagramCanvasRenderer(
    type: String,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(210.dp)
    ) {
        when (type) {
            "TRIGONOMETRY_TRIANGLE" -> drawTrigonometryTriangle()
            "CIRCLE_TANGENTS" -> drawCircleTangents()
            "COORDINATE_SYSTEM" -> drawCoordinateSystem()
            "ELECTRIC_CIRCUIT_OHM" -> drawElectricCircuit()
            "HUMAN_EYE" -> drawHumanEye()
            "RAY_CONCAVE_MIRROR" -> drawConcaveMirrorRay()
            "MAGNETIC_SOLENOID" -> drawMagneticSolenoid()
            "STOMATA_CELL" -> drawStomata()
            else -> drawGenericConcept(type)
        }
    }
}

private fun DrawScope.drawTrigonometryTriangle() {
    val left = size.width * 0.22f
    val right = size.width * 0.82f
    val bottom = size.height * 0.82f
    val top = size.height * 0.20f

    // Triangle ABC: A is top-left, B is bottom-left (90 deg), C is bottom-right (angle theta)
    val a = Offset(left, top)
    val b = Offset(left, bottom)
    val c = Offset(right, bottom)

    val path = Path().apply {
        moveTo(a.x, a.y)
        lineTo(b.x, b.y)
        lineTo(c.x, c.y)
        close()
    }

    // Fill subtle
    drawPath(path, Color(0x333B82F6))
    // Outline
    drawPath(path, Color(0xFF60A5FA), style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round))

    // Right angle symbol at B
    val squareSize = 24f
    drawPath(
        Path().apply {
            moveTo(left, bottom - squareSize)
            lineTo(left + squareSize, bottom - squareSize)
            lineTo(left + squareSize, bottom)
        },
        Color(0xFFFBBF24),
        style = Stroke(width = 2.dp.toPx())
    )

    // Theta arc at C
    drawArc(
        color = Color(0xFF34D399),
        startAngle = 180f,
        sweepAngle = 36f,
        useCenter = false,
        topLeft = Offset(c.x - 60f, c.y - 45f),
        size = Size(60f, 60f),
        style = Stroke(width = 3.dp.toPx())
    )

    // Key points dots
    drawCircle(Color(0xFFEF4444), radius = 6f, center = a)
    drawCircle(Color(0xFFFBBF24), radius = 6f, center = b)
    drawCircle(Color(0xFF10B981), radius = 6f, center = c)
}

private fun DrawScope.drawCircleTangents() {
    val center = Offset(size.width * 0.65f, size.height * 0.5f)
    val radius = size.height * 0.35f
    val p = Offset(size.width * 0.15f, size.height * 0.5f)

    // Circle
    drawCircle(
        color = Color(0xFF3B82F6),
        radius = radius,
        center = center,
        style = Stroke(width = 3.dp.toPx())
    )

    // Contact points A and B
    val a = Offset(center.x - radius * 0.5f, center.y - radius * 0.866f)
    val b = Offset(center.x - radius * 0.5f, center.y + radius * 0.866f)

    // Tangents PA and PB
    drawLine(Color(0xFFF59E0B), p, a, strokeWidth = 3.dp.toPx(), cap = StrokeCap.Round)
    drawLine(Color(0xFFF59E0B), p, b, strokeWidth = 3.dp.toPx(), cap = StrokeCap.Round)

    // Radii OA and OB
    drawLine(Color(0xFF10B981), center, a, strokeWidth = 2.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)))
    drawLine(Color(0xFF10B981), center, b, strokeWidth = 2.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)))

    // Line OP
    drawLine(Color(0xFF94A3B8), center, p, strokeWidth = 1.5.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f)))

    // Points
    drawCircle(Color.White, radius = 5f, center = center)
    drawCircle(Color(0xFFEF4444), radius = 6f, center = p)
    drawCircle(Color(0xFFF59E0B), radius = 5f, center = a)
    drawCircle(Color(0xFFF59E0B), radius = 5f, center = b)
}

private fun DrawScope.drawCoordinateSystem() {
    val cx = size.width * 0.5f
    val cy = size.height * 0.5f

    // Grid lines
    val gridColor = Color(0xFF1E293B)
    for (i in -4..4) {
        val x = cx + i * (size.width * 0.1f)
        val y = cy + i * (size.height * 0.1f)
        drawLine(gridColor, Offset(x, 0f), Offset(x, size.height), strokeWidth = 1f)
        drawLine(gridColor, Offset(0f, y), Offset(size.width, y), strokeWidth = 1f)
    }

    // Axes
    drawLine(Color(0xFF94A3B8), Offset(30f, cy), Offset(size.width - 30f, cy), strokeWidth = 3.dp.toPx())
    drawLine(Color(0xFF94A3B8), Offset(cx, size.height - 20f), Offset(cx, 20f), strokeWidth = 3.dp.toPx())

    // Arrowheads
    drawLine(Color(0xFF94A3B8), Offset(size.width - 30f, cy), Offset(size.width - 45f, cy - 10f), strokeWidth = 2.5.dp.toPx())
    drawLine(Color(0xFF94A3B8), Offset(size.width - 30f, cy), Offset(size.width - 45f, cy + 10f), strokeWidth = 2.5.dp.toPx())
    drawLine(Color(0xFF94A3B8), Offset(cx, 20f), Offset(cx - 10f, 35f), strokeWidth = 2.5.dp.toPx())
    drawLine(Color(0xFF94A3B8), Offset(cx, 20f), Offset(cx + 10f, 35f), strokeWidth = 2.5.dp.toPx())

    // Origin Dot
    drawCircle(Color(0xFFF59E0B), radius = 6f, center = Offset(cx, cy))
}

private fun DrawScope.drawElectricCircuit() {
    val left = size.width * 0.18f
    val right = size.width * 0.82f
    val top = size.height * 0.22f
    val bottom = size.height * 0.78f

    // Main circuit loop
    val path = Path().apply {
        moveTo(left, top)
        lineTo(right, top)
        lineTo(right, bottom)
        lineTo(left, bottom)
        close()
    }
    drawPath(path, Color(0xFF64748B), style = Stroke(width = 3.dp.toPx()))

    // Resistor zigzag on top branch
    val rxStart = size.width * 0.40f
    val rxEnd = size.width * 0.60f
    drawRect(Color(0xFF0F172A), topLeft = Offset(rxStart, top - 15f), size = Size(rxEnd - rxStart, 30f))
    val rZigzag = Path().apply {
        moveTo(rxStart, top)
        lineTo(rxStart + 15f, top - 14f)
        lineTo(rxStart + 35f, top + 14f)
        lineTo(rxStart + 55f, top - 14f)
        lineTo(rxStart + 75f, top + 14f)
        lineTo(rxEnd, top)
    }
    drawPath(rZigzag, Color(0xFF38BDF8), style = Stroke(width = 3.dp.toPx()))

    // Voltmeter branch in parallel across R
    val vPath = Path().apply {
        moveTo(rxStart - 10f, top)
        lineTo(rxStart - 10f, top - 40f)
        lineTo(rxEnd + 10f, top - 40f)
        lineTo(rxEnd + 10f, top)
    }
    drawPath(vPath, Color(0xFFF43F5E), style = Stroke(width = 2.dp.toPx()))
    val vCenter = Offset((rxStart + rxEnd) / 2, top - 40f)
    drawCircle(Color(0xFF0F172A), radius = 18f, center = vCenter)
    drawCircle(Color(0xFFF43F5E), radius = 18f, center = vCenter, style = Stroke(width = 2.dp.toPx()))

    // Battery on bottom branch
    val bx = size.width * 0.45f
    drawRect(Color(0xFF0F172A), topLeft = Offset(bx - 30f, bottom - 20f), size = Size(80f, 40f))
    // Long line (+)
    drawLine(Color(0xFF10B981), Offset(bx - 10f, bottom - 18f), Offset(bx - 10f, bottom + 18f), strokeWidth = 4.dp.toPx())
    // Short thick line (-)
    drawLine(Color(0xFFEF4444), Offset(bx + 10f, bottom - 10f), Offset(bx + 10f, bottom + 10f), strokeWidth = 7.dp.toPx())

    // Ammeter on right branch
    val ay = (top + bottom) / 2
    drawCircle(Color(0xFF0F172A), radius = 18f, center = Offset(right, ay))
    drawCircle(Color(0xFFF59E0B), radius = 18f, center = Offset(right, ay), style = Stroke(width = 2.dp.toPx()))
}

private fun DrawScope.drawHumanEye() {
    val cx = size.width * 0.55f
    val cy = size.height * 0.5f
    val r = size.height * 0.38f

    // Outer Eye Sphere (Retina wall at back)
    drawArc(
        color = Color(0xFF60A5FA),
        startAngle = 40f,
        sweepAngle = 280f,
        useCenter = false,
        topLeft = Offset(cx - r, cy - r),
        size = Size(r * 2, r * 2),
        style = Stroke(width = 4.dp.toPx())
    )

    // Retina Yellow lining on back
    drawArc(
        color = Color(0xFFFBBF24),
        startAngle = 130f,
        sweepAngle = 100f,
        useCenter = false,
        topLeft = Offset(cx - r + 6f, cy - r + 6f),
        size = Size((r - 3f) * 2, (r - 3f) * 2),
        style = Stroke(width = 3.dp.toPx())
    )

    // Bulging Cornea at front
    val corneaLeft = cx - r - 25f
    drawArc(
        color = Color(0xFF38BDF8),
        startAngle = 280f,
        sweepAngle = 160f,
        useCenter = false,
        topLeft = Offset(corneaLeft, cy - r * 0.6f),
        size = Size(65f, r * 1.2f),
        style = Stroke(width = 3.dp.toPx())
    )

    // Crystalline Convex Lens
    val lensX = cx - r * 0.55f
    val lensPath = Path().apply {
        moveTo(lensX, cy - 35f)
        quadraticBezierTo(lensX + 18f, cy, lensX, cy + 35f)
        quadraticBezierTo(lensX - 18f, cy, lensX, cy - 35f)
        close()
    }
    drawPath(lensPath, Color(0x663B82F6))
    drawPath(lensPath, Color(0xFF93C5FD), style = Stroke(width = 2.5.dp.toPx()))

    // Optic Nerve back exit
    val backX = cx + r
    drawLine(Color(0xFFE2E8F0), Offset(backX - 5f, cy - 12f), Offset(backX + 35f, cy - 16f), strokeWidth = 3.dp.toPx())
    drawLine(Color(0xFFE2E8F0), Offset(backX - 5f, cy + 12f), Offset(backX + 35f, cy + 16f), strokeWidth = 3.dp.toPx())
}

private fun DrawScope.drawConcaveMirrorRay() {
    val mirrorX = size.width * 0.85f
    val cy = size.height * 0.5f

    // Principal Axis
    drawLine(Color(0xFF64748B), Offset(20f, cy), Offset(size.width - 20f, cy), strokeWidth = 2.dp.toPx())

    // Concave Mirror Arc
    drawArc(
        color = Color(0xFF38BDF8),
        startAngle = 120f,
        sweepAngle = 120f,
        useCenter = false,
        topLeft = Offset(mirrorX - 60f, cy - 80f),
        size = Size(80f, 160f),
        style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
    )

    // Key points on axis
    val pole = Offset(mirrorX - 20f, cy)
    val focus = Offset(mirrorX - 110f, cy)
    val centerC = Offset(mirrorX - 200f, cy)

    drawCircle(Color.White, radius = 4f, center = pole)
    drawCircle(Color(0xFFFBBF24), radius = 5f, center = focus)
    drawCircle(Color(0xFFF43F5E), radius = 5f, center = centerC)

    // Object between C and F (Arrow pointing up)
    val objX = (centerC.x + focus.x) / 2
    val objTop = cy - 45f
    drawLine(Color(0xFF10B981), Offset(objX, cy), Offset(objX, objTop), strokeWidth = 3.5.dp.toPx())
    drawCircle(Color(0xFF10B981), radius = 5f, center = Offset(objX, objTop))

    // Ray 1: Parallel to axis, reflects through focus
    drawLine(Color(0xFFFCD34D), Offset(objX, objTop), Offset(mirrorX - 22f, objTop), strokeWidth = 2.dp.toPx())
    drawLine(Color(0xFFFCD34D), Offset(mirrorX - 22f, objTop), Offset(centerC.x - 70f, cy + 75f), strokeWidth = 2.dp.toPx())

    // Inverted Real Image beyond C (Arrow pointing down)
    val imgX = centerC.x - 45f
    val imgBottom = cy + 70f
    drawLine(Color(0xFFEF4444), Offset(imgX, cy), Offset(imgX, imgBottom), strokeWidth = 4.dp.toPx())
    drawCircle(Color(0xFFEF4444), radius = 5f, center = Offset(imgX, imgBottom))
}

private fun DrawScope.drawMagneticSolenoid() {
    val left = size.width * 0.25f
    val right = size.width * 0.75f
    val cy = size.height * 0.5f

    // Solenoid Coils
    val coils = 6
    val step = (right - left) / coils
    for (i in 0 until coils) {
        val x = left + i * step
        drawArc(
            color = Color(0xFFF59E0B),
            startAngle = 100f,
            sweepAngle = 160f,
            useCenter = false,
            topLeft = Offset(x, cy - 35f),
            size = Size(step, 70f),
            style = Stroke(width = 3.5.dp.toPx())
        )
    }

    // Inside Uniform Field Lines (straight green lines)
    drawLine(Color(0xFF10B981), Offset(left - 20f, cy - 12f), Offset(right + 20f, cy - 12f), strokeWidth = 2.dp.toPx())
    drawLine(Color(0xFF10B981), Offset(left - 30f, cy), Offset(right + 30f, cy), strokeWidth = 2.5.dp.toPx())
    drawLine(Color(0xFF10B981), Offset(left - 20f, cy + 12f), Offset(right + 20f, cy + 12f), strokeWidth = 2.dp.toPx())

    // Looping magnetic lines outside (top and bottom)
    drawArc(
        color = Color(0xFF38BDF8),
        startAngle = 180f,
        sweepAngle = 180f,
        useCenter = false,
        topLeft = Offset(left - 40f, cy - 85f),
        size = Size((right - left) + 80f, 100f),
        style = Stroke(width = 2.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 8f)))
    )
    drawArc(
        color = Color(0xFF38BDF8),
        startAngle = 0f,
        sweepAngle = 180f,
        useCenter = false,
        topLeft = Offset(left - 40f, cy - 15f),
        size = Size((right - left) + 80f, 100f),
        style = Stroke(width = 2.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 8f)))
    )
}

private fun DrawScope.drawStomata() {
    val cx = size.width * 0.5f
    val cy = size.height * 0.5f

    // Guard cell 1 (Left curved bean)
    val pathLeft = Path().apply {
        moveTo(cx - 5f, cy - 55f)
        cubicTo(cx - 55f, cy - 35f, cx - 55f, cy + 35f, cx - 5f, cy + 55f)
        cubicTo(cx - 20f, cy + 30f, cx - 20f, cy - 30f, cx - 5f, cy - 55f)
        close()
    }
    drawPath(pathLeft, Color(0xFF15803D))
    drawPath(pathLeft, Color(0xFF4ADE80), style = Stroke(width = 3.dp.toPx()))

    // Guard cell 2 (Right curved bean)
    val pathRight = Path().apply {
        moveTo(cx + 5f, cy - 55f)
        cubicTo(cx + 55f, cy - 35f, cx + 55f, cy + 35f, cx + 5f, cy + 55f)
        cubicTo(cx + 20f, cy + 30f, cx + 20f, cy - 30f, cx + 5f, cy - 55f)
        close()
    }
    drawPath(pathRight, Color(0xFF15803D))
    drawPath(pathRight, Color(0xFF4ADE80), style = Stroke(width = 3.dp.toPx()))

    // Chloroplast dots inside guard cells
    val dots = listOf(
        Offset(cx - 30f, cy - 25f), Offset(cx - 35f, cy), Offset(cx - 28f, cy + 25f),
        Offset(cx + 30f, cy - 25f), Offset(cx + 35f, cy), Offset(cx + 28f, cy + 25f)
    )
    dots.forEach { dot ->
        drawCircle(Color(0xFF86EFAC), radius = 4f, center = dot)
    }

    // Stomatal Pore in center (dark aperture)
    drawOval(
        color = Color(0xFF022C22),
        topLeft = Offset(cx - 10f, cy - 30f),
        size = Size(20f, 60f)
    )
}

private fun DrawScope.drawGenericConcept(title: String) {
    drawCircle(Color(0xFF3B82F6), radius = 60f, center = Offset(size.width * 0.5f, size.height * 0.5f), style = Stroke(width = 3.dp.toPx()))
    drawCircle(Color(0xFF10B981), radius = 30f, center = Offset(size.width * 0.5f, size.height * 0.5f))
}
